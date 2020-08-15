package JavaApi.D0809.Homework;

import Util.io.IOHelper;

import java.io.*;
import java.util.Scanner;

//请根据要求完成如下操作:
//        1 在控制台输出 D:\ 目录下所有文件和目录
//        2 创建文件夹 myfiles
//        3 在 myfiles 文件夹中创建以下文件 注意,如果文件已经存在,需要提示用户该文件已经存在:
//        readme.txt
//        info.txt test.ini tools.txt students.ini baidu.inf taobao.inf helloworld.java
//        head.jpg red.gif green.bmp
//        5 过滤查询所有的 txt 文件
//        6 修改所有的图片文件,将文件名前面加入" 图片" https://cloud.tencent.com/developer/article/1195478
//        7 删除所有以字母 t 开头文件  https://cloud.tencent.com/developer/article/1195478
//        8 在 readme.txt 文件中,使用流写入一首唐诗
//        9 使用流将 readme.txt 的内容读取出来, 并输出到控制台上

public class Main {
    private static File dir = new File("H:\\jetbrains\\java\\YcS1.2\\src\\JavaApi\\D0809\\Homework\\myfiles");
    private static String[] str = new String[]{"readme.txt", "info.txt", "test.ini", "tools.txt", "students.ini", "baidu.inf",
            "helloworld.java", "head.jpg", "red.gif", "green.bmp", "taobao.inf"};
    private static Scanner input = new Scanner(System.in);
    private static Main TestFile;

    public static void main(String[] args) throws IOException {
        JP();
    }

    public static void menu() {
        System.out.println(
                "1 在控制台输出 D:\\ 目录下所有文件和目录\n" +
                        "2 创建文件夹 myfiles" + "\n" +
                        "3 在 myfiles 文件夹中创建以下文件 \n" +
                        "4 过滤查询所有的 txt 文件\n" +
                        "5 修改所有的图片文件,将文件名前面加入 图片 \n" +
                        "6 删除所有以字母 t 开头文件 \n" +
                        "7 在 readme.txt 文件中,使用流写入一首唐诗\n" +
                        "8 使用流将 readme.txt 的内容读取出来, 并输出到控制台上");
    }

    private static void JP() throws IOException {
        while (true) {
            menu();
            int a = input.nextInt();
            switch (a) {
                case 1:
                    fileD();
                    break;
                case 2:
                    if (!dir.exists()) {
                        //如果文件夹不存在
                        dir.mkdir();
                        //创建文件夹
                    } else {
                        System.out.println(dir.getName() + " 该文件已经存在");
                    }
                    break;
                case 3:
                    for (int i = 0; i < str.length; i++) {
                        files(str[i]);
                    }
                    break;
                case 4:
                    FilenameFilter filter = new TxtFilenameFilter();
                    //使用内部类来实现接口
                    String[] filess = dir.list(filter);
                    for (String filename : filess) {
                        System.out.println(filename);
                    }
                    break;
                case 5:
                    change("图片");
                    break;
                case 6:
                    for (int i = 0; i < str.length; i++) {
                        if (str[i].substring(0, 1).equals("t")) {
                            delFolder(str[i]);
                        }
                    }
                    break;
                case 7:
                    writer("readme.txt", "独在异乡为异客，每逢佳节倍思亲。\n" +
                            "遥知兄弟登高处，遍插茱萸少一人。");
                    break;
                case 8:
                    read();
                    break;
                default:
                    System.out.println("输入错误");
                    JP();

            }
        }
    }

    public static void fileD() {
        File f = new File("D:\\");
        boolean b = false;
        try {
            TestFile.fileList(f);
        } catch (Exception e) {
        }
    }

    public static void fileList(File file) {
        File[] files = file.listFiles();
        if (files != null) {
            for (File f1 : files) {
                System.out.println(f1.getAbsolutePath());
                fileList(f1);
            }
        }
    }


    /*
    创建文件
     */
    public static void files(String name) {

        File file = new File(dir, name);
        if (!file.exists()) {
            try {
                // 创建新文件
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("创建新文件时出现了错误。。。");
                e.printStackTrace();
            }
        } else {
            System.out.println(file.getName() + " 该文件已经存在");
        }
    }

    /**
     * 过滤查询所有的 txt 文件
     */
    public static void chTxt() {
        File file = new File(String.valueOf(dir));
        FilenameFilter filter = new TxtFilenameFilter();//使用内部类来实现接口
        String[] filess = file.list(filter);
        for (String filename : filess) {
            System.out.println(filename);
        }
    }

    static class TxtFilenameFilter implements FilenameFilter {

        @Override
        public boolean accept(File dir, String name) {
            return name.endsWith("txt");
        }
    }

    /**
     * 删除文件夹
     *
     * @param name 文件名
     */
    public static void delFolder(String name) {
        try {


            File file = new File(dir, name);
            file.delete();
            //删除文件
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void read() throws IOException {
        File file = new File(dir, "readme.txt");

        StringBuilder sb = new StringBuilder();
        String s = "";
        BufferedReader br = new BufferedReader(new FileReader(file));

        while ((s = br.readLine()) != null) {
            sb.append(s).append("\n");
        }
        br.close();
        String str = sb.toString();
        System.out.println(str);
    }

    /**
     * @param filename 文件名
     * @param poetry   唐诗
     */
    public static void writer(String filename, String poetry) {

        File file = new File(dir, filename);
        FileWriter fw = null;

        try {
            fw = new FileWriter(file);
            fw.write(poetry);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOHelper.close(fw);
        }
    }

    /**
     * @param name
     */
    public static void change(String name) {

        FilenameFilter filter = new TuFilenameFilter();//使用内部类来实现接口
        String[] filess = dir.list(filter);
        File[] file = new File[filess.length];
        String[] files1 = new String[filess.length];
        for (int i = 0; i < filess.length; i++) {
            file[i] = new File(dir, filess[i]);
            files1[i] = file[i].getAbsolutePath();
        }
        for (int i = 0; i < files1.length; i++) {
            testRenameFile(files1[i], name);
        }

    }


    static class TuFilenameFilter implements FilenameFilter {
        @Override
        public boolean accept(File dir, String name) {
            return name.endsWith("jpg") || name.endsWith("gif") || name.endsWith("bmp");
        }
    }

    /**
     * 重命名一个文件：将原来的文件直接修改
     * @param filePath 文件路径
     * @param name     要加文件名
     */
    private static void testRenameFile(String filePath, String name) {

        int a = filePath.lastIndexOf("s");
        try {
            File src = new File(filePath);
            StringBuffer stringBuilder1 = new StringBuffer(filePath);
            stringBuilder1.insert(a + 2, name);
            filePath = String.valueOf(stringBuilder1);
            File des = new File(filePath);
            if (des.exists()) {
                boolean res = des.delete();
                if (!res) {
                    System.out.println("删除文件失败");
                }
            }
            if (!src.renameTo(des)) {
                System.out.println("重命名文件失败");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            IOHelper.close();
        }
    }

}






