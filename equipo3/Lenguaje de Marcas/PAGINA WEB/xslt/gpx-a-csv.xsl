<xsl:stylesheet version="1.0"
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
  xmlns:gpx="http://www.topografix.com/GPX/1/1"
  exclude-result-prefixes="gpx">

  <xsl:output method="text" encoding="UTF-8"/>

  <xsl:template match="/">
    <xsl:text>Ruta,Latitud,Longitud,Elevación&#10;</xsl:text>
    <xsl:for-each select="//gpx:trk">
      <xsl:variable name="ruta" select="gpx:name"/>
      <xsl:for-each select="gpx:trkseg/gpx:trkpt">
        <xsl:value-of select="$ruta"/><xsl:text>,</xsl:text>
        <xsl:value-of select="@lat"/><xsl:text>,</xsl:text>
        <xsl:value-of select="@lon"/><xsl:text>,</xsl:text>
        <xsl:value-of select="gpx:ele"/>
        <xsl:text>&#10;</xsl:text>
      </xsl:for-each>
    </xsl:for-each>
  </xsl:template>
</xsl:stylesheet>
