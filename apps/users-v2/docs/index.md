# Users APIs Docs
Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incidunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrum exercitationem ullamco laboriosam, nisi ut aliquid ex ea commodi consequatur. Duis aute irure reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint obcaecat cupiditat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.

# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]
### Added
- New CI/CD pipeline for automated deployment on OpenShift.

## [2.0.0] - 2026-03-25
### Added
- Added the new `/v2/user/{id}` endpoint to support the new data model (#42).
- Implemented OIDC integration with Keycloak for authentication (@mronconi).
- Configured the `mkdocs.yml` file for TechDocs documentation generation.

### Changed
- The organization name in the portal is now dynamically displayed from the configuration file.

### Deprecated
- The `/v1/user/{id}` endpoint is officially deprecated and will be removed in version 3.0.0.

### Fixed
- Fixed the missing relations warning in the catalog by correctly assigning ownership to the user (`user:mronconi`).

## [1.0.0] - 2026-02-10
### Added
- Initial release of the `users-component`.
- Base OpenAPI 3.1.0 definition for the v1 API.

---
[Unreleased]: https://github.com/mronconis/rhcl-demo/compare/v2.0.0...HEAD
[2.0.0]: https://github.com/mronconis/rhcl-demo/compare/v1.0.0...v2.0.0
[1.0.0]: https://github.com/mronconis/rhcl-demo/releases/tag/v1.0.0