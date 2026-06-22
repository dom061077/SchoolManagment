FROM quay.io/keycloak/keycloak:21.1.1

# Copy custom themes
COPY keycloak-theme/schoolmanagement /opt/keycloak/themes/schoolmanagement
