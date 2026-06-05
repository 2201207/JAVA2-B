//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
void main() {
    String inputPath = ".\\data\\sample.txt";
    String outputPath = "\\data\\sample_cpoy.txt";
    int count = 0;
    File file = new File(inputPath);
    if (file.exists()){
        try {
            FileReader fileReader = new FileReader(file, Charset.defaultCharset());
            FileWriter fileWriter = new FileWriter(outputPath, Charset.defaultCharset());
            int data;
            char[] buffer = new char[8192];
            while ((data = fileReader.read(buffer)) != -1){
                fileWriter.write(buffer, 0, data);
                count += data;
            }
            System.out.printf("%,d Bytes 복사완료\n", count);
            Runtime.getRuntime().exec("notepad.exe " + outputPath);
            ProcessBuilder builder = new ProcessBuilder("mspaint", new File(outputPath).getAbsolutePath());
            builder.start();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }else{
        System.out.printf("%s 파일이 존재하지않아요\n", inputPath);
    }
}
