package cn.gaple.extra.ueditor.config;

import cn.gaple.extra.ueditor.define.GXState;
import cn.gaple.extra.ueditor.hunter.GXFileManager;
import cn.gaple.extra.ueditor.hunter.GXImageHunter;
import cn.gaple.extra.ueditor.upload.GXEditorUploader;
import cn.gaple.extra.ueditor.upload.impl.GXBase64Uploader;
import cn.gaple.extra.ueditor.upload.impl.GXBinaryUploader;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Component
public class GXDefaultEditorUploader implements GXEditorUploader {
    @Resource
    private GXBinaryUploader binaryUploader;

    @Override
    public GXState binaryUpload(HttpServletRequest request, Map<String, Object> conf) {
        return binaryUploader.save(request, conf);
    }

    @Override
    public GXState base64Upload(HttpServletRequest request, Map<String, Object> conf) {
        String filedName = (String) conf.get("fieldName");
        return GXBase64Uploader.save(request.getParameter(filedName), conf);
    }

    @Override
    public GXState listImage(int index, Map<String, Object> conf) {
        return new GXFileManager(conf).listFile(index);
    }

    @Override
    public GXState listFile(int index, Map<String, Object> conf) {
        return new GXFileManager(conf).listFile(index);
    }

    @Override
    public GXState imageHunter(String[] list, Map<String, Object> conf) {
        return new GXImageHunter(conf).capture(list);
    }
}