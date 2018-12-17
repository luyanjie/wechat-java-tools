package com.xinba.wechat.api;


import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class WxMessageInMemoryDuplicateCheckerTest {
  private WxMessageInMemoryDuplicateChecker checker = new WxMessageInMemoryDuplicateChecker(2000L, 1000L);

  @Test
  public void test() throws InterruptedException {
    Long[] msgIds = new Long[]{1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L};

    System.out.println("第一次检查");
    // 第一次检查
    for (Long msgId : msgIds) {
      boolean result = checker.isDuplicate(String.valueOf(msgId));
      System.out.println(result);
      // assertFalse(result);
    }

    System.out.println("===================");
    System.out.println("过1秒再检查");
    // 过1秒再检查
    TimeUnit.SECONDS.sleep(1);
    for (Long msgId : msgIds) {
      boolean result = checker.isDuplicate(String.valueOf(msgId));
      System.out.println(result);
      // assertTrue(result);
    }

    System.out.println("===================");
    System.out.println("过1.5秒再检查");
    // 过1.5秒再检查
    TimeUnit.MILLISECONDS.sleep(1500L);
    for (Long msgId : msgIds) {
      boolean result = checker.isDuplicate(String.valueOf(msgId));
      System.out.println(result);
      // assertFalse(result);
    }

  }

}
