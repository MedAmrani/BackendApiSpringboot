# Crowdfunding plateform using Spring boot & Angular 8

The establishment of a Crowdfunding platform, service oriented, based on several "Spring, Microservices, SPA" technologies.

Tasks :
1. Implementation of a UML design for the project.
2. Development of the Backend part "Java, SpringBoot, Spring MVC, IOC, DATA, micro-services, Spring Security, JWT".
3. Development of the FrontEnd part “TypeScript, Angular 8, Angular Materials”.



WITH FilteredData AS (
    SELECT
        client_id, -- Assuming a column for client identification
        axn_date,
        dos_element_id,
        axn_ticket_key,
        axn_element_id,
        axn_type
    FROM
        Decision_Action
    WHERE
        axn_date >= rundate
),

MaxDossier AS (
    SELECT
        client_id,
        axn_date,
        MAX(dos_element_id) AS max_dos_element_id
    FROM
        FilteredData
    GROUP BY
        client_id, axn_date
),

ConcatenatedTickets AS (
    SELECT
        client_id,
        axn_date,
        STRING_AGG(DISTINCT axn_ticket_key, '|') AS I_TICKET_BE
    FROM
        FilteredData
    WHERE
        axn_ticket_key IS NOT NULL AND axn_ticket_key != ''
    GROUP BY
        client_id, axn_date
),

ConcatenatedActions AS (
    SELECT
        client_id,
        axn_date,
        STRING_AGG(DISTINCT axn_type, '|') AS C_CONCAT_ACTION_BE
    FROM
        FilteredData
    WHERE
        axn_type IS NOT NULL AND axn_type != ''
    GROUP BY
        client_id, axn_date
),

ActionCount AS (
    SELECT
        client_id,
        axn_date,
        COUNT(DISTINCT axn_type) AS Q_ACTION
    FROM
        FilteredData
    WHERE
        axn_type IS NOT NULL AND axn_type != ''
    GROUP BY
        client_id, axn_date
)

SELECT
    F.client_id,
    F.axn_date,
    M.max_dos_element_id AS I_DOSSIER,
    T.I_TICKET_BE,
    A.C_CONCAT_ACTION_BE,
    C.Q_ACTION
FROM
    FilteredData F
    LEFT JOIN MaxDossier M ON F.client_id = M.client_id AND F.axn_date = M.axn_date
    LEFT JOIN ConcatenatedTickets T ON F.client_id = T.client_id AND F.axn_date = T.axn_date
    LEFT JOIN ConcatenatedActions A ON F.client_id = A.client_id AND F.axn_date = A.axn_date
    LEFT JOIN ActionCount C ON F.client_id = C.client_id AND F.axn_date = C.axn_date
GROUP BY
    F.client_id, F.axn_date, M.max_dos_element_id, T.I_TICKET_BE, A.C_CONCAT_ACTION_BE, C.Q_ACTION;
