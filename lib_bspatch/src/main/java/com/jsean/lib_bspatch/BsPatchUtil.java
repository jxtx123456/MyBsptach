package com.jsean.lib_bspatch;

/**
 * @author: david
 * @date: 2020/12/21
 * @des:
 */
public class BsPatchUtil {


    static {
        System.loadLibrary("native-lib");
    }

    /**
     * 合成差分包
     * @param oldApk    旧版本的apk
     * @param patch     拆分包，patch文件
     * @param outPut    合成后新版本apk的输出路径
     */
    public native void bsPatch(String oldApk,String patch,String outPut);



}
