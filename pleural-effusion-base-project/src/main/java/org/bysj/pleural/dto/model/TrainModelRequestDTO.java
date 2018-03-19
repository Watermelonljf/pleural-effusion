package org.bysj.pleural.dto.model;

import io.swagger.models.auth.In;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * <pre>类名: TrainModelRequestDTO</pre>
 * <pre>描述: 模型训练请求DTO</pre>
 * <pre>日期: 2018/3/19  15:44</pre>
 * <pre>作者: ljianf</pre>
 */
@Data
@NoArgsConstructor
@ToString
public class TrainModelRequestDTO {

    private String algorithm;

    private Integer popSize;

    private Integer maxgen;

}
