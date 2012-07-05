package com.osjobu.camara;

import java.io.File;
import android.os.Environment;
/**
 * Created with IntelliJ IDEA.
 * User: Oscar
 * Date: 5/07/12
 * Time: 01:01 PM
 * To change this template use File | Settings | File Templates.
 */


public final class FroyoAlbumDirFactory extends AlbumStorageDirFactory {

    @Override
    public File getAlbumStorageDir(String albumName) {
        // TODO Auto-generated method stub
        return new File(
                Environment.getExternalStoragePublicDirectory(
                        Environment.DIRECTORY_PICTURES
                ),
                albumName
        );
    }
}
