package cn.gaple.extra.ueditor.upload.impl;

import cn.gaple.extra.ueditor.GXPathFormat;
import cn.gaple.extra.ueditor.GXStorageManager;
import cn.gaple.extra.ueditor.config.GXEditorProperties;
import cn.gaple.extra.ueditor.define.GXBaseState;
import cn.gaple.extra.ueditor.define.GXEditorResponseInfo;
import cn.gaple.extra.ueditor.define.GXFileType;
import cn.gaple.extra.ueditor.define.GXState;
import cn.maple.core.framework.util.GXSpringContextUtils;
import org.apache.tomcat.util.codec.binary.Base64;

import java.util.Map;

public class GXBase64Uploader {
    private static final GXEditorProperties properties;

    static {
        properties = GXSpringContextUtils.getBean(GXEditorProperties.class);
    }

    private GXBase64Uploader() {
    }

    public static GXState save(String content, Map<String, Object> conf) {
        byte[] data = decode(content);
        long maxSize = (Long) conf.get("maxSize");
        if (!validSize(data, maxSize)) {
            return new GXBaseState(false, GXEditorResponseInfo.MAX_SIZE);
        }
        String suffix = GXFileType.getSuffix("JPG");
        String savePath = GXPathFormat.parse((String) conf.get("savePath"), (String) conf.get("filename"));
        savePath = savePath + suffix;
        String physicalPath = GXPathFormat.format(properties.getLocal().getPhysicalPath() + "/" + savePath);
        GXState storageState = GXStorageManager.saveBinaryFile(data, physicalPath);
        if (storageState.isSuccess()) {
            storageState.putInfo("url", GXPathFormat.format(conf.get("contextPath") + "/" + properties.getLocal().getUrlPrefix() + savePath));
            storageState.putInfo("type", suffix);
            storageState.putInfo("original", "");
        }
        return storageState;
    }

    private static byte[] decode(String content) {
        return Base64.decodeBase64(content);
    }

    private static boolean validSize(byte[] data, long length) {
        return data.length <= length;
    }
}
