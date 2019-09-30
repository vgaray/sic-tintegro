package pe.com.tintegro.dto.request;


public class InsertarQueuesRequest extends RequestBase
{
	private String name; 
	private String musiconHold; 
	private String announce; 
	private String context; 
	private Integer timeOut; 
	private String monitorJoin; 
	private String monitorFormat; 
	private String queueYouAreNext; 
	private String queueThereAre;
	private String queueCallsWaiting;
	private String queueHoldTime;
	private String queueMinutes;
	private String queueSeconds;
	private String queueLessThan;
	private String queueThankYou;
	private String queueReportHold;
	private Integer announceFrequency;
	private Integer announceRoundSeconds;
	private String announceHoldtime;
	private Integer retry;
	private Integer wrapuptime;
	private Integer maxlen;
	private Integer serviceLevel;
	private String strategy;
	private String joinEmpty;
	private String leavewhenempty;
	private String eventmemberstatus;
	private String eventwhencalled;
	private String reportholdtime;
	private Integer memberdelay;
	private Integer weight;
	private String timeoutRestart;
	private String ringinuse;
	private String announcePeriodic;
	private String announcePeriodicTime;
	private String monitorJoinSelect;
	private String eventMemberstatusTime;
	private String timeoutRestartTime;
	

	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getMusiconHold()
	{
		return musiconHold;
	}
	public void setMusiconHold(String musiconHold)
	{
		this.musiconHold = musiconHold;
	}
	public String getAnnounce()
	{
		return announce;
	}
	public void setAnnounce(String announce)
	{
		this.announce = announce;
	}
	public String getContext()
	{
		return context;
	}
	public void setContext(String context)
	{
		this.context = context;
	}
	public Integer getTimeOut()
	{
		return timeOut;
	}
	public void setTimeOut(Integer timeOut)
	{
		this.timeOut = timeOut;
	}
	public String getMonitorJoin()
	{
		return monitorJoin;
	}
	public void setMonitorJoin(String monitorJoin)
	{
		this.monitorJoin = monitorJoin;
	}
	public String getMonitorFormat()
	{
		return monitorFormat;
	}
	public void setMonitorFormat(String monitorFormat)
	{
		this.monitorFormat = monitorFormat;
	}
	public String getQueueYouAreNext()
	{
		return queueYouAreNext;
	}
	public void setQueueYouAreNext(String queueYouAreNext)
	{
		this.queueYouAreNext = queueYouAreNext;
	}
	public String getQueueThereAre()
	{
		return queueThereAre;
	}
	public void setQueueThereAre(String queueThereAre)
	{
		this.queueThereAre = queueThereAre;
	}
	public String getQueueCallsWaiting()
	{
		return queueCallsWaiting;
	}
	public void setQueueCallsWaiting(String queueCallsWaiting)
	{
		this.queueCallsWaiting = queueCallsWaiting;
	}
	public String getQueueHoldTime()
	{
		return queueHoldTime;
	}
	public void setQueueHoldTime(String queueHoldTime)
	{
		this.queueHoldTime = queueHoldTime;
	}
	public String getQueueMinutes()
	{
		return queueMinutes;
	}
	public void setQueueMinutes(String queueMinutes)
	{
		this.queueMinutes = queueMinutes;
	}
	public String getQueueSeconds()
	{
		return queueSeconds;
	}
	public void setQueueSeconds(String queueSeconds)
	{
		this.queueSeconds = queueSeconds;
	}
	public String getQueueLessThan()
	{
		return queueLessThan;
	}
	public void setQueueLessThan(String queueLessThan)
	{
		this.queueLessThan = queueLessThan;
	}
	public String getQueueThankYou()
	{
		return queueThankYou;
	}
	public void setQueueThankYou(String queueThankYou)
	{
		this.queueThankYou = queueThankYou;
	}
	public String getQueueReportHold()
	{
		return queueReportHold;
	}
	public void setQueueReportHold(String queueReportHold)
	{
		this.queueReportHold = queueReportHold;
	}
	public Integer getAnnounceFrequency()
	{
		return announceFrequency;
	}
	public void setAnnounceFrequency(Integer announceFrequency)
	{
		this.announceFrequency = announceFrequency;
	}
	public Integer getAnnounceRoundSeconds()
	{
		return announceRoundSeconds;
	}
	public void setAnnounceRoundSeconds(Integer announceRoundSeconds)
	{
		this.announceRoundSeconds = announceRoundSeconds;
	}
	public String getAnnounceHoldtime()
	{
		return announceHoldtime;
	}
	public void setAnnounceHoldtime(String announceHoldtime)
	{
		this.announceHoldtime = announceHoldtime;
	}
	public Integer getRetry()
	{
		return retry;
	}
	public void setRetry(Integer retry)
	{
		this.retry = retry;
	}
	public Integer getWrapuptime()
	{
		return wrapuptime;
	}
	public void setWrapuptime(Integer wrapuptime)
	{
		this.wrapuptime = wrapuptime;
	}
	public Integer getMaxlen()
	{
		return maxlen;
	}
	public void setMaxlen(Integer maxlen)
	{
		this.maxlen = maxlen;
	}
	public Integer getServiceLevel()
	{
		return serviceLevel;
	}
	public void setServiceLevel(Integer serviceLevel)
	{
		this.serviceLevel = serviceLevel;
	}
	public String getStrategy()
	{
		return strategy;
	}
	public void setStrategy(String strategy)
	{
		this.strategy = strategy;
	}
	public String getJoinEmpty()
	{
		return joinEmpty;
	}
	public void setJoinEmpty(String joinEmpty)
	{
		this.joinEmpty = joinEmpty;
	}
	public String getLeavewhenempty()
	{
		return leavewhenempty;
	}
	public void setLeavewhenempty(String leavewhenempty)
	{
		this.leavewhenempty = leavewhenempty;
	}
	public String getEventmemberstatus()
	{
		return eventmemberstatus;
	}
	public void setEventmemberstatus(String eventmemberstatus)
	{
		this.eventmemberstatus = eventmemberstatus;
	}
	public String getEventwhencalled()
	{
		return eventwhencalled;
	}
	public void setEventwhencalled(String eventwhencalled)
	{
		this.eventwhencalled = eventwhencalled;
	}
	public String getReportholdtime()
	{
		return reportholdtime;
	}
	public void setReportholdtime(String reportholdtime)
	{
		this.reportholdtime = reportholdtime;
	}
	public Integer getMemberdelay()
	{
		return memberdelay;
	}
	public void setMemberdelay(Integer memberdelay)
	{
		this.memberdelay = memberdelay;
	}
	public Integer getWeight()
	{
		return weight;
	}
	public void setWeight(Integer weight)
	{
		this.weight = weight;
	}

	public String getRinginuse()
	{
		return ringinuse;
	}
	public void setRinginuse(String ringinuse)
	{
		this.ringinuse = ringinuse;
	}
	public String getAnnouncePeriodic()
	{
		return announcePeriodic;
	}
	public void setAnnouncePeriodic(String announcePeriodic)
	{
		this.announcePeriodic = announcePeriodic;
	}
	public String getTimeoutRestart()
	{
		return timeoutRestart;
	}
	public void setTimeoutRestart(String timeoutRestart)
	{
		this.timeoutRestart = timeoutRestart;
	}
	public String getAnnouncePeriodicTime() {
		return announcePeriodicTime;
	}
	public void setAnnouncePeriodicTime(String announcePeriodicTime) {
		this.announcePeriodicTime = announcePeriodicTime;
	}
	public String getMonitorJoinSelect() {
		return monitorJoinSelect;
	}
	public void setMonitorJoinSelect(String monitorJoinSelect) {
		this.monitorJoinSelect = monitorJoinSelect;
	}
	public String getEventMemberstatusTime() {
		return eventMemberstatusTime;
	}
	public void setEventMemberstatusText(String eventMemberstatusTime) {
		this.eventMemberstatusTime = eventMemberstatusTime;
	}
	public String getTimeoutRestartTime() {
		return timeoutRestartTime;
	}
	public void setTimeoutRestartTime(String timeoutRestartTime) {
		this.timeoutRestartTime = timeoutRestartTime;
	}
}
