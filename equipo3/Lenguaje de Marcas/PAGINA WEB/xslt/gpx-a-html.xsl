<xsl:stylesheet version="1.0"
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
  xmlns:gpx="http://www.topografix.com/GPX/1/1"
  exclude-result-prefixes="gpx">

  <xsl:output method="html" encoding="UTF-8" indent="yes"/>

  <xsl:template match="/">
    <html>
      <head>
        <title>Listado de Rutas</title>
        <link rel="stylesheet" href="estilos.css"/>
      </head>
      <body>
        <header>
          <h1>Gestor de Rutas</h1>
        </header>
        <main>
          <h2>Rutas extraídas del GPX</h2>
          <xsl:for-each select="//gpx:trk">
            <div class="ruta">
              <h3><xsl:value-of select="gpx:name"/></h3>
              <p><strong>Puntos totales:</strong> <xsl:value-of select="count(gpx:trkseg/gpx:trkpt)"/></p>
            </div>
          </xsl:for-each>
        </main>
        <footer>
          <p>Proyecto de Gestión de Rutas - Lenguaje de Marcas</p>
        </footer>
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>
