package jp.naver.lineplay.listviewtuning.Data;

public class Data {
    public String url;
    public String Main_Title;
    public String Sub_Title;

    public Data(String url, String _Main_Title,
                String _Sub_Title) {

        this.url = url;
        this.Main_Title = _Main_Title;
        this.Sub_Title = _Sub_Title;

    }

    public Data() {
    }
}
