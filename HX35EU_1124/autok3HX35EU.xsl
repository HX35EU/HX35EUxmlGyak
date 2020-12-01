<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="3.0">

    <xsl:param name="input" select="'url to json file'"/>
   
    <xsl:template name="xsl:initial-template">
        <xsl:apply-templates select="json-to-xml(unparsed-text($input))"/>
    </xsl:template>
</xsl:stylesheet>