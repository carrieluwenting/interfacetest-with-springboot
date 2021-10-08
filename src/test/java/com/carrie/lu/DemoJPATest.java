package com.carrie.lu;

import com.carrie.lu.config.entity.DemoEntity;
import com.carrie.lu.service.DemoJPAService;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;
import org.junit.jupiter.api.parallel.Resources;

import java.util.List;

import static com.carrie.lu.util.ComponentFactory.$;

@ResourceLock(value = Resources.SYSTEM_PROPERTIES, mode = ResourceAccessMode.READ_WRITE)
public class DemoJPATest extends DemoTest {

    @Test
    public void testCreate() {
        for (int i=0; i<10; i++) {
            DemoEntity demo = new DemoEntity();
            demo.setTrafficId(i);
            demo.setStatus("11200");
            demo.setMessage(RandomStringUtils.randomAlphabetic(10));
            demo.setSpeedInMps(RandomStringUtils.randomNumeric(3));
            demo.setTrafficLevel(RandomUtils.nextInt());

            $(DemoJPAService.class).save(demo);
        }
    }

    @Test
    public void testGet() {
        System.out.println("testing");
        List<DemoEntity> demoEntityList = $(DemoJPAService.class).findAll();
        for(DemoEntity demoEntity : demoEntityList) {
            System.out.println("***************************");
            System.out.println(demoEntity.getTrafficId());
            System.out.println(demoEntity.getStatus());
            System.out.println(demoEntity.getMessage());
            System.out.println(demoEntity.getSpeedInMps());
            System.out.println(demoEntity.getTrafficLevel());
        }

        int trafficLevel = $(DemoJPAService.class).findById(102).getTrafficLevel();
        System.out.println(trafficLevel);

        List<DemoEntity> demoEntityList2 = $(DemoJPAService.class).findByStatus("11200");
    }
}
