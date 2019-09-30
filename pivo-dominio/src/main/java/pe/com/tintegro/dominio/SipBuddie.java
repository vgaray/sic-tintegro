package pe.com.tintegro.dominio;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class SipBuddie
{
	private int id;
	private String name;
	private String type;
	private String fullcontact;
	private int regseconds;
	private String ipaddr;
	private String musicclass;
	private String relaxdtmf;
	private String usereqphone;
	private String compactheaders;
	private String callevents;
	private String ignoreregexpire;
	private String context;
	private String callingpres;
	private String deny;
	private String permit;
	private String secret;
	private String md5secret;
	private String dtmfmode;
	private String canreinvite;
	private String nat;
	private String callgroup;
	private String pickupgroup;
	private String language;
	private String disallow;
	private String allow;
	private String insecure;
	private String trustrpid;
	private String progressinband;
	private String promiscredir;
	private String useclientcode;
	private String accountcode;
	private String setvar;
	private String callerid;
	private String amaflags;
	private String call_limit;
	private String restrictcid;
	private String allowoverlap;
	private String allowsubscribe;
	private String subscribecontext;
	private String videosupport;
	private String maxcallbitrate;
	private String mailbox;
	private String voicemail;
	private String username;
	private String template;
	private String fromdomain;
	private String regexten;
	private String fromuser;
	private String host;
	private String port;
	private String qualify;
	private String defaultip;
	private String rtptimeout;
	private String rtpholdtimeout;
	private String sendrpid;
	private String regserver;
	private String usecallingpres;
	private String usuarioSIPcadena;
	private int uso;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public String getFullcontact()
	{
		return fullcontact;
	}

	public void setFullcontact(String fullcontact)
	{
		this.fullcontact = fullcontact;
	}

	public int getRegseconds()
	{
		return regseconds;
	}

	public void setRegseconds(int regseconds)
	{
		this.regseconds = regseconds;
	}

	public String getIpaddr()
	{
		return ipaddr;
	}

	public void setIpaddr(String ipaddr)
	{
		this.ipaddr = ipaddr;
	}

	public String getMusicclass()
	{
		return musicclass;
	}

	public void setMusicclass(String musicclass)
	{
		this.musicclass = musicclass;
	}

	public String getRelaxdtmf()
	{
		return relaxdtmf;
	}

	public void setRelaxdtmf(String relaxdtmf)
	{
		this.relaxdtmf = relaxdtmf;
	}

	public String getUsereqphone()
	{
		return usereqphone;
	}

	public void setUsereqphone(String usereqphone)
	{
		this.usereqphone = usereqphone;
	}

	public String getCompactheaders()
	{
		return compactheaders;
	}

	public void setCompactheaders(String compactheaders)
	{
		this.compactheaders = compactheaders;
	}

	public String getCallevents()
	{
		return callevents;
	}

	public void setCallevents(String callevents)
	{
		this.callevents = callevents;
	}

	public String getIgnoreregexpire()
	{
		return ignoreregexpire;
	}

	public String getVoicemail()
	{
		return voicemail;
	}

	public void setVoicemail(String voicemail)
	{
		this.voicemail = voicemail;
	}

	public void setIgnoreregexpire(String ignoreregexpire)
	{
		this.ignoreregexpire = ignoreregexpire;
	}

	public String getContext()
	{
		return context;
	}

	public void setContext(String context)
	{
		this.context = context;
	}

	public String getCallingpres()
	{
		return callingpres;
	}

	public void setCallingpres(String callingpres)
	{
		this.callingpres = callingpres;
	}

	public String getDeny()
	{
		return deny;
	}

	public void setDeny(String deny)
	{
		this.deny = deny;
	}

	public String getPermit()
	{
		return permit;
	}

	public void setPermit(String permit)
	{
		this.permit = permit;
	}

	public String getSecret()
	{
		return secret;
	}

	public void setSecret(String secret)
	{
		this.secret = secret;
	}

	public String getMd5secret()
	{
		return md5secret;
	}

	public void setMd5secret(String md5secret)
	{
		this.md5secret = md5secret;
	}

	public String getDtmfmode()
	{
		return dtmfmode;
	}

	public void setDtmfmode(String dtmfmode)
	{
		this.dtmfmode = dtmfmode;
	}

	public String getCanreinvite()
	{
		return canreinvite;
	}

	public void setCanreinvite(String canreinvite)
	{
		this.canreinvite = canreinvite;
	}

	public String getNat()
	{
		return nat;
	}

	public void setNat(String nat)
	{
		this.nat = nat;
	}

	public String getCallgroup()
	{
		return callgroup;
	}

	public void setCallgroup(String callgroup)
	{
		this.callgroup = callgroup;
	}

	public String getPickupgroup()
	{
		return pickupgroup;
	}

	public void setPickupgroup(String pickupgroup)
	{
		this.pickupgroup = pickupgroup;
	}

	public String getLanguage()
	{
		return language;
	}

	public void setLanguage(String language)
	{
		this.language = language;
	}

	public String getDisallow()
	{
		return disallow;
	}

	public void setDisallow(String disallow)
	{
		this.disallow = disallow;
	}

	public String getAllow()
	{
		return allow;
	}

	public void setAllow(String allow)
	{
		this.allow = allow;
	}

	public String getInsecure()
	{
		return insecure;
	}

	public void setInsecure(String insecure)
	{
		this.insecure = insecure;
	}

	public String getTrustrpid()
	{
		return trustrpid;
	}

	public void setTrustrpid(String trustrpid)
	{
		this.trustrpid = trustrpid;
	}

	public String getProgressinband()
	{
		return progressinband;
	}

	public void setProgressinband(String progressinband)
	{
		this.progressinband = progressinband;
	}

	public String getPromiscredir()
	{
		return promiscredir;
	}

	public void setPromiscredir(String promiscredir)
	{
		this.promiscredir = promiscredir;
	}

	public String getUseclientcode()
	{
		return useclientcode;
	}

	public void setUseclientcode(String useclientcode)
	{
		this.useclientcode = useclientcode;
	}

	public String getAccountcode()
	{
		return accountcode;
	}

	public void setAccountcode(String accountcode)
	{
		this.accountcode = accountcode;
	}

	public String getSetvar()
	{
		return setvar;
	}

	public void setSetvar(String setvar)
	{
		this.setvar = setvar;
	}

	public String getCallerid()
	{
		return callerid;
	}

	public void setCallerid(String callerid)
	{
		this.callerid = callerid;
	}

	public String getAmaflags()
	{
		return amaflags;
	}

	public void setAmaflags(String amaflags)
	{
		this.amaflags = amaflags;
	}

	public String getCall_limit()
	{
		return call_limit;
	}

	public void setCall_limit(String call_limit)
	{
		this.call_limit = call_limit;
	}

	public String getRestrictcid()
	{
		return restrictcid;
	}

	public void setRestrictcid(String restrictcid)
	{
		this.restrictcid = restrictcid;
	}

	public String getAllowoverlap()
	{
		return allowoverlap;
	}

	public void setAllowoverlap(String allowoverlap)
	{
		this.allowoverlap = allowoverlap;
	}

	public String getAllowsubscribe()
	{
		return allowsubscribe;
	}

	public void setAllowsubscribe(String allowsubscribe)
	{
		this.allowsubscribe = allowsubscribe;
	}

	public String getSubscribecontext()
	{
		return subscribecontext;
	}

	public void setSubscribecontext(String subscribecontext)
	{
		this.subscribecontext = subscribecontext;
	}

	public String getVideosupport()
	{
		return videosupport;
	}

	public void setVideosupport(String videosupport)
	{
		this.videosupport = videosupport;
	}

	public String getMaxcallbitrate()
	{
		return maxcallbitrate;
	}

	public void setMaxcallbitrate(String maxcallbitrate)
	{
		this.maxcallbitrate = maxcallbitrate;
	}

	public String getMailbox()
	{
		return mailbox;
	}

	public void setMailbox(String mailbox)
	{
		this.mailbox = mailbox;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getTemplate()
	{
		return template;
	}

	public void setTemplate(String template)
	{
		this.template = template;
	}

	public String getFromdomain()
	{
		return fromdomain;
	}

	public void setFromdomain(String fromdomain)
	{
		this.fromdomain = fromdomain;
	}

	public String getRegexten()
	{
		return regexten;
	}

	public void setRegexten(String regexten)
	{
		this.regexten = regexten;
	}

	public String getFromuser()
	{
		return fromuser;
	}

	public void setFromuser(String fromuser)
	{
		this.fromuser = fromuser;
	}

	public String getHost()
	{
		return host;
	}

	public void setHost(String host)
	{
		this.host = host;
	}

	public String getPort()
	{
		return port;
	}

	public void setPort(String port)
	{
		this.port = port;
	}

	public String getQualify()
	{
		return qualify;
	}

	public void setQualify(String qualify)
	{
		this.qualify = qualify;
	}

	public String getDefaultip()
	{
		return defaultip;
	}

	public void setDefaultip(String defaultip)
	{
		this.defaultip = defaultip;
	}

	public String getRtptimeout()
	{
		return rtptimeout;
	}

	public void setRtptimeout(String rtptimeout)
	{
		this.rtptimeout = rtptimeout;
	}

	public String getRtpholdtimeout()
	{
		return rtpholdtimeout;
	}

	public void setRtpholdtimeout(String rtpholdtimeout)
	{
		this.rtpholdtimeout = rtpholdtimeout;
	}

	public String getSendrpid()
	{
		return sendrpid;
	}

	public void setSendrpid(String sendrpid)
	{
		this.sendrpid = sendrpid;
	}

	public String getRegserver()
	{
		return regserver;
	}

	public void setRegserver(String regserver)
	{
		this.regserver = regserver;
	}

	public String getUsecallingpres()
	{
		return usecallingpres;
	}

	public void setUsecallingpres(String usecallingpres)
	{
		this.usecallingpres = usecallingpres;
	}

	public String getUsuarioSIPcadena()
	{
		return usuarioSIPcadena;
	}

	public void setUsuarioSIPcadena(String usuarioSIPcadena)
	{
		this.usuarioSIPcadena = usuarioSIPcadena;
	}

	public int getUso()
	{
		return uso;
	}

	public void setUso(int uso)
	{
		this.uso = uso;
	}

}
