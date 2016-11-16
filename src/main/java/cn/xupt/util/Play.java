package cn.xupt.util;


public class Play
{
    private String playName;
    private String playType;
    private String playLang;
    private String playIntroduce;
    private int playLength;
    private float playTicketPrice;
    private String playImage;
    private int status; // 0���������ݳ� 1���Ѱ����ݳ� -1������

    public String getPlayName()
    {
        return playName;
    }

    public void setPlayName(String playName)
    {
        this.playName = playName;
    }

    public String getPlayType()
    {
        return playType;
    }

    public void setPlayType(String playType)
    {
        this.playType = playType;
    }

    public String getPlayLang()
    {
        return playLang;
    }

    public void setPlayLang(String playLang)
    {
        this.playLang = playLang;
    }

   

    public String getPlayIntroduce() {
		return playIntroduce;
	}

	public void setPlayIntroduce(String playIntroduce) {
		this.playIntroduce = playIntroduce;
	}

	public int getPlayLength()
    {
        return playLength;
    }

    public void setPlayLength(int playLength)
    {
        this.playLength = playLength;
    }

    public float getPlayTicketPrice()
    {
        return playTicketPrice;
    }

    public void setPlayTicketPrice(float playTicketPrice)
    {
        this.playTicketPrice = playTicketPrice;
    }

    public String getPlayImage()
    {
        return playImage;
    }

    public void setPlayImage(String playImage)
    {
        this.playImage = playImage;
    }

    public int getStatus()
    {
        return status;
    }

    public void setStatus(int status)
    {
        this.status = status;
    }
}
