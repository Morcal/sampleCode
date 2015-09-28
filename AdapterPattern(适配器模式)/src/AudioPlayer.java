//创建实现了MediaPlayer接口的实体类
public class AudioPlayer implements MediaPlayer {
	MediaAdapter mediaAdapter;

	@Override
	public void play(String audioType, String fileName) {
		// TODO Auto-generated method stub
		// 播放MP3音乐文件内置
		if (audioType.equalsIgnoreCase("mp3")) {
			System.out.println("Playing mp3 file Name:" + fileName);

		}
		// mediaAdapter提供播放其他文件支持
		else if (audioType.equalsIgnoreCase("vlc")
				|| audioType.equalsIgnoreCase("mp4")) {
			mediaAdapter = new MediaAdapter(audioType);
			mediaAdapter.play(audioType, fileName);
		} else {
			System.out.println("Invalid media " + audioType
					+ " format not support");
		}
	}
}
