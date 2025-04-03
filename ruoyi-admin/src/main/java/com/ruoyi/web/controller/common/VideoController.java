package com.ruoyi.web.controller.common;

import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.uuid.IdUtils;
import com.ruoyi.common.utils.video.NonStaticResourceHttpRequestHandler;
import org.apache.commons.compress.utils.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author zheng yang
 * @date 2022/4/19 10:02
 */
@RequestMapping(value = "/video")
@Controller
public class VideoController {

    @Autowired
    private NonStaticResourceHttpRequestHandler nonStaticResourceHttpRequestHandler;

    // 视频上传
    @PostMapping("/fileupload")
    @ResponseBody
    public AjaxResult uploadFile(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String dirPath = RuoYiConfig.getUploadWeightPicPath() + "/" + DateUtils.datePath() + "/";
        String fileName = IdUtils.fastUUID() + ".mp4";
        // String fileFullPath = dirPath + System.getProperty("file.separator") + fileName;
        String fileFullPath = dirPath + fileName;
        InputStream input = null;
        FileOutputStream fos = null;
        AjaxResult result;
        try {
            input = request.getInputStream();
            File file = new File(dirPath);
            if (!file.exists()) {
                file.mkdirs();
            }
            fos = new FileOutputStream(fileFullPath);
            byte[] buffer = new byte[1024];
            int length = 0;
            do {
                length = input.read(buffer);
                if (length > 0) {
                    fos.write(buffer, 0, length);
                }
            } while (length > 0);
            result = AjaxResult.success(fileFullPath);
        } catch (IOException e) {
            e.printStackTrace();
            result = AjaxResult.error("上传图片异常，请联系管理员");
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    // 前端播放方式1  <video controls autoplay src="http://localhost:8080/video/getVideo1"/>
    @RequestMapping(value = "/getVideo1", method = RequestMethod.GET)
    @ResponseBody
    public void getVido(HttpServletRequest request, HttpServletResponse response) {
        String file = request.getParameter("filePath");
        try {
            //	获得视频文件的输入流
            FileInputStream inputStream = new FileInputStream(file);
            // 创建字节数组，数组大小为视频文件大小
            byte[] data = new byte[inputStream.available()];
            // 将视频文件读入到字节数组中
            inputStream.read(data);
            String diskfilename = "final.mp4";
            // 设置返回数据格式
            response.setContentType("video/mp4");
            response.setHeader("Content-Disposition", "attachment; filename=\"" + diskfilename + "\"");
            response.setContentLength(data.length);
            response.setHeader("Content-Range", "" + Integer.valueOf(data.length - 1));
            response.setHeader("Accept-Ranges", "bytes");
            response.setHeader("Etag", "W/\"9767057-1323779115364\"");
            // 获得 response 的字节流
            OutputStream os = response.getOutputStream();
            // 将视频文件的字节数组写入 response 中
            os.write(data);
            //先声明的流后关掉！
            os.flush();
            os.close();
            inputStream.close();
        } catch (Exception ignored) {
        }
    }

    // 前端播放方式2
    @RequestMapping(value = "/getVideo2", method = RequestMethod.GET)
    @ResponseBody
    public void getPreview2(HttpServletResponse response) {
        try {
            File file = new File("D:/electron-ruoyi/jiankong.mp4");
            response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
            response.setHeader("Content-Disposition", "attachment; filename=" + file.getName().replace(" ", "_"));
            InputStream iStream = new FileInputStream(file);
            IOUtils.copy(iStream, response.getOutputStream());
            response.flushBuffer();
        } catch (java.nio.file.NoSuchFileException e) {
            response.setStatus(HttpStatus.NOT_FOUND.value());
        } catch (Exception e) {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    }

    // 后端直接播放
    @GetMapping("/preview")
    public void videoPreview(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //sourcePath 是获取编译后 resources 文件夹的绝对地址，获得的原始 sourcePath 以/开头，所以要用 substring(1) 去掉第一个字符/
        //realPath 即视频所在的完整地址
        String sourcePath = this.getClass().getClassLoader().getResource("").getPath().substring(1);
        String realPath = sourcePath + "static/video/1.mp4";
        // Path filePath = Paths.get(realPath);
        Path filePath = Paths.get("D:/electron-ruoyi/jiankong.mp4");
        if (Files.exists(filePath)) {
            // 利用 Files.probeContentType 获取文件类型
            String mimeType = Files.probeContentType(filePath);
            if (!StringUtils.isEmpty(mimeType)) {
                // 设置 response
                response.setContentType(mimeType);
            }
            request.setAttribute(nonStaticResourceHttpRequestHandler.filepath, filePath);
            // 利用 ResourceHttpRequestHandler.handlerRequest() 实现返回视频流
            nonStaticResourceHttpRequestHandler.handleRequest(request, response);
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            response.setCharacterEncoding(StandardCharsets.UTF_8.toString());
        }
    }

}
