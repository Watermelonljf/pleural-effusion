package org.bysj.pleural;


import org.bysj.pleural.bean.Xqjy;
import org.bysj.pleural.service.ModelTrainService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BaseApplication.class)
public class DiagnoseApplicationTests {

	@Autowired
	private ModelTrainService modleTrainService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testGetAllXqjy(){
		List<Xqjy> allXqjy = modleTrainService.getTrainData();
		Arrays.asList(allXqjy).toString();
	}


}
