package practise1;

//只想让该方法对其所在类的子类可见，则将该方法声明为 protected
//如果把 openSpeaker() 方法声明为 private，那么除了 AudioPlayer 之外的类将不能访问该方法

//父类中声明为 public 的方法在子类中也必须为 public
//父类中声明为 protected 的方法在子类中要么声明为 protected，要么声明为 public，不能声明为 private
//父类中声明为 private 的方法，不能够被继承

final class AudioPlayer_final{
    AudioPlayer_final(){
        System.out.println("AudioPlayer_final instanced");
    }
}

//final 修饰的类不能被继承
//class StreamingAudioPlayer_0 extends AudioPlayer_final{
//
//}

class AudioPlayer {
    static String class_name;
    static{class_name="AudioPlayer name";}
    AudioPlayer(){
        System.out.println("AudioPlayer instanced");
    }
    protected String openSpeaker() {
        // 实现细节
        return "method from AudioPlayer";
    }
    protected final String openSpeaker_final(){
        return "final method AudioPlayer";
    }
}

class StreamingAudioPlayer extends AudioPlayer {
    static{class_name="StreamingAudioPlayer name";}
    StreamingAudioPlayer(){
        System.out.println("StreamingAudioPlayer instanced");
    }
    protected String openSpeaker() {
        // 实现细节
        return "method from StreamingAudioPlayer";
    }
//    final修饰的方法不能被重写
//    protected String openSpeaker_final(){
//        return "final method StreamingAudioPlayer";
//    }
    public int openSpeaker(int pra1){
        return pra1;
    }

}


public class protected_Test {
    public static void main(String[] args){
        AudioPlayer audio_player1 = new AudioPlayer();
        System.out.println("calling method from father class --- AudioPlayer");
        System.out.println(audio_player1.openSpeaker());
        System.out.println("static variable from father class ---"+AudioPlayer.class_name);
        System.out.println("===================");
        StreamingAudioPlayer streaming_player1 = new StreamingAudioPlayer();
        System.out.println("calling method from child class --- StreamingAudioPlayer");
        System.out.println(streaming_player1.openSpeaker());
        System.out.println("calling method from child class --- StreamingAudioPlayer");
        System.out.println(streaming_player1.openSpeaker(123));
        System.out.println("static variable from child class ---"+StreamingAudioPlayer.class_name);
    }
}
