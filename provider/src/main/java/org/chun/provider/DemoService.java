package org.chun.provider;

import org.apache.dubbo.config.annotation.DubboService;
import org.chun.interfaces.IDemoService;

@DubboService
public class DemoService implements IDemoService {

  @Override
  public String message(String name) {
    return String.format("Name: %s", name);
  }
}
