package com.ruoyi.web.controller.common;

import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.file.FileUploadUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author zheng yang
 * @date 2022/3/8 16:53
 */
@Api("称重图片上传")
@RestController
@RequestMapping("/weight")
public class WeightPicController {

    /**
     * 称重图片上传
     */
    // @Log(title = "称重图片", businessType 单张sType.UPDATE)
    @ApiOperation("上传单张图片")
    @PostMapping("/pic")
    public AjaxResult weightPic(@RequestParam("weightPic") MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            String weightPicUrl = FileUploadUtils.upload(RuoYiConfig.getUploadWeightPicPath(), file);
            System.out.println(weightPicUrl);
            return AjaxResult.success(weightPicUrl);
        }
        return AjaxResult.error("上传图片异常，请联系管理员");
    }

    @ApiOperation("上传多张图片")
    @PostMapping("/pics")
    public AjaxResult weightPics(@RequestParam("weightPics") MultipartFile[] files) throws IOException {
        StringBuilder weightPicUrl = new StringBuilder();
        if (files != null && files.length > 0) {
            for (MultipartFile file : files) {
                weightPicUrl.append("/dev-api").append(FileUploadUtils.upload(RuoYiConfig.getUploadWeightPicPath(), file)).append("|");
            }
            return AjaxResult.success(weightPicUrl.toString());
        }
        return AjaxResult.error("上传图片异常，请联系管理员");
    }
}
