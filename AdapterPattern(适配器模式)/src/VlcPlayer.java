//创建实现AdvanceMediaPlayer接口的实体类
public class VlcPlayer implements AdvancedMediaPlayer {

	@Override
	public void playVlc(String fileName) {
		// TODO Auto-generated method stub
		System.out.println("Playing vlc file Name:" + fileName);
	}

	@Override
	public void playMp4(String fileName) {
		// TODO Auto-generated method stub
		// 什么也不做
	}

}
