<?xml version="1.0" encoding="UTF-8"?>
<TestSuiteEntity>
   <description>-Create customer to get customerID.
-Then create 2 accounts and get 2 accountID + current balances
-Then account no.1 transfer money to account no.2
-Then check both of accounts' balances
-Then check mini statement of account no.1</description>
   <name>TS04_CreateAccount THEN Transfer THEN Check Balance, Check Custom Statement</name>
   <tag></tag>
   <isRerun>false</isRerun>
   <mailRecipient></mailRecipient>
   <numberOfRerun>0</numberOfRerun>
   <pageLoadTimeout>30</pageLoadTimeout>
   <pageLoadTimeoutDefault>true</pageLoadTimeoutDefault>
   <rerunFailedTestCasesOnly>false</rerunFailedTestCasesOnly>
   <rerunImmediately>false</rerunImmediately>
   <testSuiteGuid>4a43f8fe-7054-400b-a52e-73a34547fa0b</testSuiteGuid>
   <testCaseLink>
      <guid>c377f20b-da66-4754-9c7d-2aff934251bc</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/Test Farm/Flow 3/Create Customer, 2 Accs THEN Transfer THEN Compare 2 Balance THEN Check Custom Statement</testCaseId>
      <testDataLink>
         <combinationType>ONE</combinationType>
         <id>fb771c21-74ab-44d0-98cd-36b8f465aa5d</id>
         <iterationEntity>
            <iterationType>ALL</iterationType>
            <value></value>
         </iterationEntity>
         <testDataId>Data Files/Fund Transfer 02</testDataId>
      </testDataLink>
      <variableLink>
         <testDataLinkId>fb771c21-74ab-44d0-98cd-36b8f465aa5d</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>accountType</value>
         <variableId>48ff4f5c-2cb7-45b2-8eef-08eb2b590b34</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>fb771c21-74ab-44d0-98cd-36b8f465aa5d</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>iniDeposit</value>
         <variableId>733c40f3-e6ce-4e70-a9fe-81317adf65df</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>fb771c21-74ab-44d0-98cd-36b8f465aa5d</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>amount</value>
         <variableId>19328b2b-c561-4dbc-8ec6-d94e7bff4524</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>fb771c21-74ab-44d0-98cd-36b8f465aa5d</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>description</value>
         <variableId>fe0aa285-1d61-4a94-9db5-331bd0dfb83c</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>fb771c21-74ab-44d0-98cd-36b8f465aa5d</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>name</value>
         <variableId>a88476eb-70e9-4643-b621-5a7a6e81df01</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>fb771c21-74ab-44d0-98cd-36b8f465aa5d</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>gender</value>
         <variableId>44d12989-8598-4709-9dfe-cbe2b016523a</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>fb771c21-74ab-44d0-98cd-36b8f465aa5d</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>dOB</value>
         <variableId>64e4baf5-21f3-4f92-a1b7-2f1668f77b46</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>fb771c21-74ab-44d0-98cd-36b8f465aa5d</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>address</value>
         <variableId>20996b7a-aadf-472c-9852-22f241d1fbbc</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>fb771c21-74ab-44d0-98cd-36b8f465aa5d</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>city</value>
         <variableId>33986708-d8e0-4b03-b01a-2c8c8165129f</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>fb771c21-74ab-44d0-98cd-36b8f465aa5d</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>state</value>
         <variableId>d26a4947-d29e-41ee-b564-f9245486b2ce</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>fb771c21-74ab-44d0-98cd-36b8f465aa5d</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>pin</value>
         <variableId>6f749ae4-6811-49a9-aac7-538e61bd1790</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>fb771c21-74ab-44d0-98cd-36b8f465aa5d</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>phone</value>
         <variableId>a34eb3e4-ed39-41b0-88e5-2caadb038857</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>fb771c21-74ab-44d0-98cd-36b8f465aa5d</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>mail</value>
         <variableId>a4114a65-9379-402f-947c-46d50c4813dc</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>fb771c21-74ab-44d0-98cd-36b8f465aa5d</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>pass</value>
         <variableId>8fee83f5-366e-42df-b5b9-d552b853794d</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>fb771c21-74ab-44d0-98cd-36b8f465aa5d</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>fromDate</value>
         <variableId>1455f3a5-6ca4-43d9-9ae5-3322839b6e43</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>fb771c21-74ab-44d0-98cd-36b8f465aa5d</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>toDate</value>
         <variableId>3b4714f0-cd0d-45c9-baa5-c6cf07f949cd</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>fb771c21-74ab-44d0-98cd-36b8f465aa5d</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>minimumValue</value>
         <variableId>c167475e-7d9e-4078-beaa-7c5cf6cc378d</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>fb771c21-74ab-44d0-98cd-36b8f465aa5d</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>numOfTransaction</value>
         <variableId>05794105-272b-44a2-adc2-438f155b7f38</variableId>
      </variableLink>
   </testCaseLink>
</TestSuiteEntity>
