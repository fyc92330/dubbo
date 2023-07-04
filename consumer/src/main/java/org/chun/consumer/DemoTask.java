package org.chun.consumer;

import org.apache.dubbo.config.annotation.DubboReference;
import org.chun.interfaces.IDemoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DemoTask implements CommandLineRunner {

  @DubboReference
  private IDemoService demoService;

  @Override
  public void run(String... args) throws Exception {
    System.out.println(demoService.message("Gordon"));

    new Thread(() -> {
      for (int i = 0; i < 50; i++) {
        try {
          Thread.sleep(1000);
          System.out.println(LocalDate.now() + " " + demoService.message("GD") + " " + i);
        } catch (InterruptedException e) {
          e.printStackTrace();
          Thread.currentThread().interrupt();
        }
      }
    }).start();
  }
}
