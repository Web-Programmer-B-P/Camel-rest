package petr.barsukov.beans;

import org.apache.camel.language.NamespacePrefix;
import org.apache.camel.language.XPath;
import org.springframework.stereotype.Component;
import petr.barsukov.types.Stat;

@Component
public class Searcher {

    public static final String NAMESPACE = "http://maven.apache.org/POM/4.0.0";
    public static final String PREFIX = "c";

    public Stat searchAndReturn(
            @XPath(
                    value = "/c:project/c:artifactId",
                    namespaces = @NamespacePrefix(
                            prefix = PREFIX,
                            uri = NAMESPACE
                    )
            ) String artifactId,
            @XPath(
                    value = "/c:project/c:version",
                    namespaces = @NamespacePrefix(
                            prefix = PREFIX,
                            uri = NAMESPACE
                    )
            ) String version
    ) {
        return new Stat(version, artifactId);
    }
}
