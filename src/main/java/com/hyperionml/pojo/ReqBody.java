package com.hyperionml.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReqBody {

    @Schema(description = "轴承id")
    private Integer sid;

    @Schema(description = "故障信息")
    private String errMsg;
}
