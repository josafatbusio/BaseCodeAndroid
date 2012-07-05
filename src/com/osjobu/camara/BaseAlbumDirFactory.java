package com.osjobu.camara;

import java.io.File;
 import android.os.Environment;

/**
 * Created with IntelliJ IDEA.
 * User: Oscar
 * Date: 5/07/12
 * Time: 01:00 PM
 * To change this template use File | Settings | File Templates.
 */

public final class BaseAlbumDirFactory extends AlbumStorageDirFactory {

    // Standard storage location for digital camera files
    private static final String CAMERA_DIR = "/dcim/";

    @Override
    public File getAlbumStorageDir(String albumName) {
        return new File (
                Environment.getExternalStorageDirectory()
                        + CAMERA_DIR
                        + albumName
        );
    }
}
