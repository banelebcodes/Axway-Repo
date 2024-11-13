# Axway Policy Studio Repository

This repository contains the Axway Policy Studio project used to publish Axway APIs. All changes and updates to the project should follow the guidelines below to ensure proper version control and deployment processes.

## Workflow

1. **Update the Repository**  
   - Always pull the latest changes from the `develop` or `main` branch before starting any work.
     ```bash
     git checkout develop # or main
     git pull origin develop # or main
     ```

2. **Create a New Branch**  
   - Create a new branch for your changes, following the naming convention.
     ```bash
     git checkout -b feature/your-feature-name
     ```

3. **Make Your Changes**  
   - Implement your changes in the repository (e.g., update API policies, configurations, etc.).

4. **Commit Your Changes**  
   - Once your changes are ready, commit them with a clear and concise message.
     ```bash
     git add .
     git commit -m "Describe your changes"
     ```

5. **Push Your Changes**  
   - Push your branch to the remote repository.
     ```bash
     git push origin feature/your-feature-name
     ```

6. **Create a Pull Request**  
   - Open a pull request (PR) against the `develop` or `main` branch on the repository.
   - Ensure your PR is reviewed and approved before merging.

7. **Publish Changes**  
   - Once your PR is merged, make sure you pull the latest changes from the `develop` or `main` branch.
     ```bash
     git checkout develop # or main
     git pull origin develop # or main
     ```

   - Then, publish the changes in the Axway Policy Studio project to the Axway API gateway.

## Notes

- Always sync with the latest version of the `develop` or `main` branch before starting any work to avoid conflicts.
- Ensure your pull requests are reviewed before merging to maintain quality and avoid issues in the deployed environment.
- Follow proper naming conventions for branches and commit messages.

## Contact

For any questions or issues, please reach out to Hennie Steyn henniesteyn@tegra.co.za.
