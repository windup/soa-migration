####Overview
There are two types of listeners in SOA 5:
* ESB-aware Listeners are used for internal message dispatch and drive an action processing pipeline.
* Gateway Listeners are used to expose services to external consumers over a protocol binding.

When migrating to SOA 5, ESB-aware listeners are no longer required.  Gateway listeners become Service Bindings in SOA 6.  A gateway listeners have a value of true for the 'is-gateway' attribute on a listener definition in jboss-esb.xml.

####Listener to Service Binding Conversion
The following table provides a mapping of SOA 5 gateway listeners to SOA 6 service bindings:
<table>
  <th>
    SOA 5 Listener
  </th>
  <th>
    SOA 6 Service Binding
  </th>
  <tr><td>fs-listener</td><td>binding.file</td></tr>
  <tr><td>ftp-listener</td><td>binding.ftp</td></tr>
  <tr><td>sql-listener</td><td>binding.sql</td></tr>
  <tr><td>jbr-listener</td><td>binding.tcp</td></tr>
  <tr><td>jms-listener</td><td>binding.jca or binding.jms</td></tr>
  <tr><td>sql-listener</td><td>binding.jpa or binding.sql</td></tr>
  <tr><td>udp-listener</td><td>binding.udp</td></tr>
</table>
