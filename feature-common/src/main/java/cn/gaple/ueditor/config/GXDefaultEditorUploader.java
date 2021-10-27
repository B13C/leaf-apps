package cn.gaple.ueditor.config;

import cn.gaple.ueditor.upload.impl.GXBase64Uploader;
import cn.gaple.ueditor.upload.impl.GXBinaryUploader;
import cn.gaple.ueditor.define.GXState;
import cn.gaple.ueditor.hunter.GXFileManager;
import cn.gaple.ueditor.hunter.GXImageHunter;
import cn.gaple.ueditor.upload.GXEditorUploader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Component
public class GXDefaultEditorUploader implements GXEditorUploader {
    @Autowired
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