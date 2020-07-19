
import java.io.*;
import java.util.Arrays;

public class Demo2 {
    public static void main(String[] args) throws Exception {
       /* String path = "E:\\Code\\vince.txt";
        String writh_path = "2.txt";
        int[] array = getArray(path);
        int[] arraySort = arraySort(array);
        write(writh_path,arraySort);*/

        String list_path = "E:\\Juc\\src\\main\\java";
        listFiles(list_path);
    }

    public static int[] getArray(String path) throws Exception {
        File file = new File(path);
        InputStream inputStream = new FileInputStream(file);
        int len = -1;
        byte[] bytes = new byte[1024];
        StringBuilder builder = new StringBuilder();
        while ((len = inputStream.read(bytes)) != -1) {
            builder.append(new String(bytes));
        }
        inputStream.close();
        String[] split = builder.toString().split(",");
        int i = 0, slen = split.length;
        int[] arr = new int[slen];
        for (String s : split) {
            arr[i++] = Integer.parseInt(s.trim());
        }
        return arr;
    }

    public static int[] arraySort(int[] arr) {
        int length = arr.length;
        for (int j = 0; j < length - 1; j++) {
            int mark = 0;
            for (int k = j; k < length; k++) {
                if (arr[j] < arr[k]) {
                    mark = arr[k];
                    arr[k] = arr[j];
                    arr[j] = mark;
                }
            }
        }
        return arr;
    }

    public static void write(String path, int[] arr) throws Exception {
        File file = new File("2.txt");
        OutputStream out = new FileOutputStream(file, true);
        out.write(Arrays.toString(arr).getBytes());
    }

    public static void listFiles(String path) {
        if (null == path)
            return;

        File[] files = new File(path).listFiles();
        if (null == files)
            return;

        for (File file : files) {
            if(file.isFile()){
                System.out.println("fileName: "+file.getName());
            }else if (file.isDirectory()){
                System.out.println("Directory:  "+file.getName());
                listFiles(file.getPath());
            }else {
                System.out.println("error");
            }
        }
    }
}
