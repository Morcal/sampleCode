//����ʵ����MediaPlayer�ӿڵ�ʵ����
public class AudioPlayer implements MediaPlayer {
	MediaAdapter mediaAdapter;

	@Override
	public void play(String audioType, String fileName) {
		// TODO Auto-generated method stub
		// ����MP3�����ļ�����
		if (audioType.equalsIgnoreCase("mp3")) {
			System.out.println("Playing mp3 file Name:" + fileName);

		}
		// mediaAdapter�ṩ���������ļ�֧��
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
