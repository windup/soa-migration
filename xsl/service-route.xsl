<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:esb="http://anonsvn.labs.jboss.com/labs/jbossesb/trunk/product/etc/schemas/xml/jbossesb-1.0.1.xsd"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	exclude-result-prefixes="esb">
	<xsl:template match="/">
		<route xmlns="http://camel.apache.org/schema/spring" xmlns:sp="http://www.springframework.org/schema/beans">
			<xsl:element name="from">
				<xsl:attribute name="uri">
    				<xsl:value-of select="concat('switchyard://', //esb:service/@name)" />
  				</xsl:attribute>
			</xsl:element>
			<xsl:apply-templates select="//esb:services/esb:service/esb:actions/esb:action"/>
		</route>
	</xsl:template>
	
	<xsl:template match="esb:action">
		<xsl:element name="to">
			<xsl:attribute name="uri">
   				<xsl:value-of select="concat('bean:', @name)" />
 			</xsl:attribute>
		</xsl:element>
	</xsl:template>
</xsl:stylesheet>