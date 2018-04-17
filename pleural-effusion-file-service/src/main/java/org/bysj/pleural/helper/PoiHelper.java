package org.bysj.pleural.helper;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bysj.pleural.dto.model.XqjyDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * className: PoiHelper
 * describe: POI帮助类
 * author: Watermelon_R
 * date:   2018/4/11
 */
@Component
public class PoiHelper {

    private static final String XLS_NAME="xls";
    private static final String EXCEL_XLSX = "xlsx";
    private Workbook getWorkbook(MultipartFile file) throws IOException {
        Workbook workbook = null;
        if(file.getOriginalFilename().endsWith(XLS_NAME)){
            workbook = new HSSFWorkbook(file.getInputStream());
        }else{
            workbook = new XSSFWorkbook(file.getInputStream());
        }
        return workbook;
    }

    public <T>List<T> getExcelDataToList(MultipartFile file,Class<T> clazz) throws IOException, InvocationTargetException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        Workbook wb = getWorkbook(file);
        return this.excel2Pojo(wb,clazz);
    }
    /**
     * 将excel表转换成指定类型的对象数组
     * @param claz 	类型
     * @param alias	列别名,格式要求：Map<"列名","类属性名">
     * @return
     * @throws IOException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     * @throws SecurityException
     * @throws NoSuchFieldException
     * @throws InstantiationException
     * @throws InvocationTargetException
     */
    public <T>List<T> excel2Pojo(Workbook wb,Class<T> claz,List<String> alias) throws IOException{
        try {
            List<T> pojoList = new ArrayList<T>();
            for(int i=0;i<wb.getNumberOfSheets();i++) {
                Sheet sheet = wb.getSheetAt(0);
                //根据指定的映射关系进行转换
                generateList(sheet, alias, claz,pojoList);
            }
            return pojoList;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally {
            wb.close();
        }
    }


    /**
     * 根据指定关系将表数据转换成对象数组
     * @param sheet  		表
     * @param claz			类类型
     * @return
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    private  <T> List<T> generateList(Sheet sheet, List<String> alias, Class<T> claz,List<T> pojoList) throws InstantiationException, IllegalAccessException, InvocationTargetException, InvocationTargetException {
        //对象数组

        for (Row row : sheet) {
            T instance = claz.newInstance();
            for (int i=0;i<alias.size()-1;i++) {
                String name = alias.get(i);
                //获取此行指定列的值,即为属性对应的值
                double property=    row.getCell(i).getNumericCellValue();
                BeanUtils.setProperty(instance, name, property);
            }
            pojoList.add(instance);
        }
        return pojoList;
    }

    /**
     * 将excel表转换成指定类型的对象数组，列名即作为对象属性
     * @param claz 	类型
     * @return
     * @throws IOException
     * @throws InstantiationException
     * @throws SecurityException
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     */
    public <T>List<T> excel2Pojo(Workbook wb, Class<T> claz) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException, InstantiationException, IOException, InvocationTargetException {
        List<String> alias = new ArrayList<>();
        Field[] fields = claz.getDeclaredFields();
        for (Field field : fields) {
            alias.add(field.getName());
        }
        List<T> pojoList = excel2Pojo(wb, claz, alias);
        return pojoList;
    }
}
