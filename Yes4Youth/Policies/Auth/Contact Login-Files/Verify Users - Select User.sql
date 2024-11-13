SELECT cd.contactid
FROM yesbmsdev.vtiger_contactdetails AS cd
JOIN yesbmsdev.vtiger_contactscf AS cf ON cd.contactid = cf.contactid
JOIN yesbmsdev.vtiger_customerdetails AS cust ON cd.contactid = cust.customerid
WHERE cf.cf_portal_password = ${http.header.password}
AND cd.email = ${http.header.username}
AND cust.portal = 1;
