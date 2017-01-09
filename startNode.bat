cd %~dp0
java -jar selenium-server-standalone-3.0.0-beta3.jar -role node -hub http://localhost:4444/grid/register -nodeConfig node.json