# Apollo11 - Knowledge Base Slack Bot service layer - (for Hackathon)


## pre-requisites
Needs the following environment variables defined:
 - ASTRA_DB_ID
 - ASTRA_DB_REGION
 - ASTRA_DB_KEYSPACE
 - ASTRA_DB_APPLICATION_TOKEN

These can be defined in the same terminal session as the application is run from.  You can also specify these env vars as a part of a run configuration in your IDE.

## To run:

    mvn clean install
    java -jar target/kbsb-0.0.1.jar

### DocumentByKeyword service
Endpoint:
 - /document/{keyword}

Table CQL:

    CREATE TABLE documents_by_keyword (
        keyword TEXT,
        title TEXT,
        document_id UUID(),
        url TEXT,
        PRIMARY KEY (keyword,title,document_id)
    );

## Example:
http://localhost:8080/document/kubernetes

    [{"keyword":"kubernetes","title":"A Case for Databases on Kubernetes from a Former Skeptic","url":"https://tobert.github.io/pages/als-cassandra-21-tuning-guide.html","document_id":"0aa68519-5fe0-40f5-b74a-a38a4f392367"},{"keyword":"kubernetes","title":"Kubernetes and Apache Cassandra: What Works (and What Doesn’t)","url":"https://tobert.github.io/pages/als-cassandra-21-tuning-guide.html","document_id":"b3b3c536-dcb5-4dfa-9db6-d2fe21f2e3f7"}]
