public class LDAP {
  private Hashtable<String, String> environment;
  public LDAP() {
    String ldapUrl = "ldap://ad.your-server.com:389";
    environment = new Hashtable<String, String>();
    environment.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
    environment.put(Context.PROVIDER_URL, ldapUrl);
    environment.put(Context.REFERRAL, "follow");
    environment.put(Context.SECURITY_AUTHENTICATION, "simple");
    environment.put(Context.SECURITY_PRINCIPAL, ldapUserName);
    environment.put(Context.SECURITY_CREDENTIALS, password);
}
