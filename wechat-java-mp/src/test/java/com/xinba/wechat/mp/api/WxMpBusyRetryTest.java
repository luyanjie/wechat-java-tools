package com.xinba.wechat.mp.api;

import com.xinba.wechat.common.error.WxError;
import com.xinba.wechat.common.error.WxErrorException;
import com.xinba.wechat.common.util.http.RequestExecutor;
import com.xinba.wechat.mp.api.impl.WxMpServiceHttpClientImpl;
import org.testng.annotations.*;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Test
public class WxMpBusyRetryTest {

    @DataProvider(name = "getService")
    public Object[][] getService() {
        WxMpService service = new WxMpServiceHttpClientImpl() {

            @Override
            public synchronized <T, E> T executeInternal(
                    RequestExecutor<T, E> executor, String uri, E data)
                    throws WxErrorException {
                this.log.info("Executed");
                throw new WxErrorException(WxError.builder().errorCode(-1).build());
            }
        };

        service.setMaxRetryTimes(3);
        service.setRetrySleepMillis(500);
        return new Object[][]{{service}};
    }

    @Test(dataProvider = "getService", expectedExceptions = RuntimeException.class)
    public void testRetry(WxMpService service) throws WxErrorException {
        service.execute(null, null, null);
    }

    @Test(dataProvider = "getService")
    public void testRetryInThreadPool(final WxMpService service) throws InterruptedException, ExecutionException {
        // 当线程池中的线程复用的时候，还是能保证相同的重试次数
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("=====================");
                    System.out.println(Thread.currentThread().getName() + ": testRetry");
                    service.execute(null, null, null);
                } catch (WxErrorException e) {
                    throw new RuntimeException(e);
                } catch (RuntimeException e) {
                    // OK
                }
            }
        };
        Future<?> submit1 = executorService.submit(runnable);
        Future<?> submit2 = executorService.submit(runnable);

        submit1.get();
        submit2.get();
    }

}
