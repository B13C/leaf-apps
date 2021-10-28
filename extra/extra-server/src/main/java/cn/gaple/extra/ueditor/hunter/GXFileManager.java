package cn.gaple.extra.ueditor.hunter;

import cn.gaple.extra.ueditor.GXPathFormat;
import cn.gaple.extra.ueditor.config.GXEditorProperties;
import cn.gaple.extra.ueditor.define.GXBaseState;
import cn.gaple.extra.ueditor.define.GXEditorResponseInfo;
import cn.gaple.extra.ueditor.define.GXMultiState;
import cn.gaple.extra.ueditor.define.GXState;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

public class GXFileManager {
    /**
     * config.json 中的 imageManagerListPath 或 fileManagerListPath 指定要列出图片/文件的目录
     */
    private final String dir;
    /**
     * 存储文件的绝对路径
     */
    private final String rootPath;
    private final String[] allowFiles;
    private final int count;
    private final String contextPath;
    @Autowired
    private GXEditorProperties properties;

    public GXFileManager(Map<String, Object> conf) {
        this.rootPath = GXPathFormat.format(properties.getLocal().getPhysicalPath());
        this.dir = (String) conf.get("dir");
        this.allowFiles = this.getAllowFiles(conf.get("allowFiles"));
        this.count = (Integer) conf.get("count");
        this.contextPath = (String) conf.get("contextPath");
    }

    public GXState listFile(int index) {
        File dir = new File(GXPathFormat.format(this.rootPath + this.dir));
        GXState state;
        if (!dir.exists()) {
            return new GXBaseState(false, GXEditorResponseInfo.NOT_EXIST);
        }
        if (!dir.isDirectory()) {
            return new GXBaseState(false, GXEditorResponseInfo.NOT_DIRECTORY);
        }
        Collection<File> list = FileUtils.listFiles(dir, this.allowFiles, true);
        if (index < 0 || index > list.size()) {
            state = new GXMultiState(true);
        } else {
            Object[] fileList = Arrays.copyOfRange(list.toArray(), index, index + this.count);
            state = this.getMyState(fileList);
        }
        state.putInfo("start", index);
        state.putInfo("total", list.size());
        return state;
    }

    private GXState getMyState(Object[] files) {
        GXMultiState state = new GXMultiState(true);
        GXBaseState fileState;
        File file;
        for (Object obj : files) {
            if (obj == null) {
                break;
            }
            file = (File) obj;
            fileState = new GXBaseState(true);
            fileState.putInfo("url", GXPathFormat.format(contextPath + "/" + properties.getLocal().getUrlPrefix() + "/" + GXPathFormat.format(file.getPath()).replaceFirst(this.rootPath, "")));
            state.addState(fileState);
        }
        return state;
    }

    private String[] getAllowFiles(Object fileExt) {
        String[] exts;
        String ext;
        if (fileExt == null) {
            return new String[0];
        }
        exts = (String[]) fileExt;
        for (int i = 0, len = exts.length; i < len; i++) {
            ext = exts[i];
            exts[i] = ext.replace(".", "");
        }
        return exts;
    }
}
