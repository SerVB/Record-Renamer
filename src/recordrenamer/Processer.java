/*
 * MIT License
 *
 * Copyright (c) 2017
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package recordrenamer;

import java.io.File;

/**
 *
 * @author SerVB
 */
public class Processer implements Runnable {
    
    private boolean changeName;
    private boolean changeTags;
    private boolean changeImage;
    
    private String path;
    
    @Override
    public void run() {
        
        changeName   = RecordRenamer.ui.jCheckBoxName .isSelected();
        changeTags   = RecordRenamer.ui.jCheckBoxTags .isSelected();
        changeImage  = RecordRenamer.ui.jCheckBoxImage.isSelected();
        
        path = RecordRenamer.ui.jTextFieldPath.getText();
        
        File folder = new File(path);
        processFilesFromFolder(folder);
        
        System.out.println("Готово!");
        
    }
    
    private void processFilesFromFolder(File folder) {
        File[] folderEntries = folder.listFiles();
        for (File entry : folderEntries) {
            if (entry.isDirectory()) {
                processFilesFromFolder(entry);
            } else {
                processFile(entry);
            }
        }
    }
    
    private void processFile(File f) {
        if (!f.getName().toLowerCase().contains(".mp3")) {
            return;
        }
        
        File newNameFile = f;
        
        if (changeName) {
            String fileName = f.getName();
            if (
                Character.isDigit(fileName.charAt(0)) &&
                Character.isDigit(fileName.charAt(1)) &&
                Character.isDigit(fileName.charAt(2)) &&
                fileName.charAt(3) == ' '
            ) {
                String newPath = f.getParent() + File.separator + fileName.substring(4);
                f.renameTo(newNameFile = new File(newPath));
            }
        }
        
        if (changeTags) {}
        
        if (changeImage) {}
    }
}
