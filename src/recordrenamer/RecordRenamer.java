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
public class RecordRenamer {

    /**
     * Папка с музыкой.
     */
    public final static String MUSIC_DIR = "D:/SerVB/Music/Record/";
    
    /**
     * Фрейм.
     */
    public static UI ui;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ui = new UI();
        ui.setVisible(true);
        
        setPath(MUSIC_DIR);
    }

    private static void setPath(String path) {
        ui.jTextFieldPath.setText(path);
    }
    
}
