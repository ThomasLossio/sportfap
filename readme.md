Ambiente:

- Eclipse
-- instalar o plugin 'jboss tools' pelo MarketPlace antes de configurar o container

- postgresql

- driver postgresql

- wildfly versão 10.1.0.Final

- maven 3.3.9



Configuração do datasource no wildfly-9.0.1.Final/standalone/configuration/standalone.xml:

                <datasource jta="true" jndi-name="java:jboss/datasources/sportfap" pool-name="sportfap" enabled="true" use-java-context="true">
                    <connection-url>jdbc:postgresql://localhost:5432/sportfap</connection-url>
                    <driver>postgresql</driver>
                    <transaction-isolation>TRANSACTION_READ_COMMITTED</transaction-isolation>
                    <pool>
                        <min-pool-size>5</min-pool-size>
                        <max-pool-size>10</max-pool-size>
                    </pool>
                    <security>
                        <user-name>postgres</user-name>
                        <password>coloque sua senha do banco aqui</password>
                    </security>
                    <validation>
                        <check-valid-connection-sql>SELECT 1</check-valid-connection-sql>
                        <validate-on-match>false</validate-on-match>
                        <background-validation>false</background-validation>
                    </validation>
                    <statement>
                        <track-statements>true</track-statements>
                        <share-prepared-statements>false</share-prepared-statements>
                    </statement>
                </datasource>            	