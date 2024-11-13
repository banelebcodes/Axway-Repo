SELECT
  *
FROM
    vtiger_contactdetails
JOIN
    vtiger_crmentity ON vtiger_contactdetails.contactid = vtiger_crmentity.crmid
WHERE
    vtiger_crmentity.deleted = 0
and vtiger_contactdetails.contactid = SUBSTRING(${http.header.id}, INSTR(${http.header.id}, 'x') + 1)
ORDER BY vtiger_contactdetails.contactid desc
LIMIT 1;
