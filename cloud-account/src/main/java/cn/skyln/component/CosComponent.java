package cn.skyln.component;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author lamella
 * @since 2022/11/27/20:20
 */
public interface CosComponent {
    /**
     * 上传文件到腾讯云COS
     *
     * @param folder     文件路径
     * @param uploadFile 待上传文件
     * @param useForName 用途
     * @return 文件访问URL
     */
    String uploadFileResult(String folder, MultipartFile uploadFile, String useForName);
}
