<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
  xmlns:gpx="http://www.topografix.com/GPX/1/1"
  exclude-result-prefixes="gpx">

  <xsl:output method="text" encoding="UTF-8"/>

  <xsl:template match="/">

    <!-- Cabecera en una línea -->
    <xsl:value-of select="//gpx:metadata/gpx:name"/><xsl:text>;</xsl:text>
    <xsl:value-of select="//gpx:metadata/gpx:author/gpx:name"/><xsl:text>;</xsl:text>
    <xsl:value-of select="//gpx:metadata/gpx:author/gpx:link/@href"/><xsl:text>;</xsl:text>
    <xsl:value-of select="//gpx:metadata/gpx:link/@href"/><xsl:text>;</xsl:text>
    <xsl:value-of select="//gpx:metadata/gpx:time"/><xsl:text>;</xsl:text>
    <xsl:text>"&#10;</xsl:text>

    <!-- Waypoints -->
    <xsl:for-each select="//gpx:wpt">
      <xsl:text>waypoint;</xsl:text>
      <xsl:value-of select="normalize-space(gpx:name)"/><xsl:text>,</xsl:text>
      <xsl:value-of select="@lat"/><xsl:text>,</xsl:text>
      <xsl:value-of select="@lon"/><xsl:text>,</xsl:text>
      <xsl:value-of select="gpx:ele"/><xsl:text>,</xsl:text>
      <xsl:value-of select="gpx:time"/><xsl:text>&#10;</xsl:text>
    </xsl:for-each>

    <!-- Trackpoints -->
    <xsl:for-each select="//gpx:trkpt">
      <xsl:text>trackpoint;</xsl:text> 
      <xsl:value-of select="@lat"/><xsl:text>,</xsl:text>
      <xsl:value-of select="@lon"/><xsl:text>,</xsl:text>
      <xsl:value-of select="gpx:ele"/><xsl:text>,</xsl:text>
      <xsl:value-of select="gpx:time"/><xsl:text>&#10;</xsl:text>
    </xsl:for-each>

  </xsl:template>
</xsl:stylesheet>
