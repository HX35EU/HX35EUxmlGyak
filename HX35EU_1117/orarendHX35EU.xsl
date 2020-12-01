<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:foo="http://www.foo.org/" xmlns:bar="http://www.bar.org">
    <xsl:template match="/">
        <html>
            <body>
                <h2>orarend</h2>
                <table border="1">
                    <tr bgcolor="#9acd32">
                        <th>targy</th>
                        <th>idopont</th>
                        <th>helyszin</th>
                        <th>oktato</th>
                        <th>szak</th>
                    </tr>
                    <xsl:for-each select="catalog/foo:cd">
                        <tr>
                            <td><xsl:value-of select="targy"/></td>
                            <td><xsl:value-of select="idopont"/></td>
                            <td><xsl:value-of select="helyszin"/></td>
                            <td><xsl:value-of select="oktato"/></td>
                            <td><xsl:value-of select="szak"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>