# Aplicação EJB de Exemplo

Aplicação de exemplo mostrando os vários tipos de EJBs, injeção de dependência, interceptadores, exceções de aplicação, métodos assíncronos e timers.

## Configurações iniciais

### Ambiente

* IDE: JBoss Studio 9

	link: (http://www.jboss.org/products/devstudio/download/) - Download da versão 9.0.0 com EAP 6.4
	
* Usar standalone-full.xml

	Aba Server > Duplo clique no servidor > Runtime Environment > Configuration File
	
#### DataSource
	
* Adicionar o conteúdo abaixo no arquivo standalone-full.xml, na seção subsytem > datasources, entre as tags **datasource** e **drivers**.

```
<xa-datasource jndi-name="java:/jdbc/CursoEJBDS" pool-name="CursoEJBDS" enabled="true" use-ccm="true" statistics-enabled="false">
	 <xa-datasource-property name="URL">jdbc:h2:mem:cursoejb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE;MVCC=true</xa-datasource-property>
	 <xa-datasource-class>org.h2.jdbcx.JdbcDataSource</xa-datasource-class>
	 <driver>h2</driver>
	 <xa-pool>
	    <is-same-rm-override>false</is-same-rm-override>
	    <interleaving>false</interleaving>
	    <pad-xid>false</pad-xid>
	    <wrap-xa-resource>false</wrap-xa-resource>
	  </xa-pool>
	  <security>
	    <user-name>sa</user-name>
	    <password>sa</password>
	  </security>
	  <validation>
	    <validate-on-match>false</validate-on-match>
	    <background-validation>false</background-validation>
	  </validation>
	  <timeout>
	    <set-tx-query-timeout>false</set-tx-query-timeout>
	    <blocking-timeout-millis>0</blocking-timeout-millis>
	    <idle-timeout-minutes>0</idle-timeout-minutes>
	    <query-timeout>0</query-timeout>
	    <use-try-lock>0</use-try-lock>
	    <allocation-retry>0</allocation-retry>
	    <allocation-retry-wait-millis>0</allocation-retry-wait-millis>
	    <xa-resource-timeout>0</xa-resource-timeout>
	  </timeout>
	  <statement>
	    <share-prepared-statements>false</share-prepared-statements>
	  </statement>
</xa-datasource>
```

#### Fila JMS

* Ainda em standalone-full.xml, adicionar o conteúdo abaixo na seção **jms-destinations**:

```
<jms-queue name="EmployeeQueue">
	<entry name="java:/jms/EmployeeQueue"/>
	<durable>true</durable>
</jms-queue>
```

	
