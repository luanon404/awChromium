import os
import shutil
import colorama

colorama.init(autoreset=True)

class Utils:
    def __init__(self, prefix: str = "/") -> None:
        self.prefix = prefix

    def copy(self, src: str, dest: str, retry_flag: bool=False) -> None:
        os.makedirs(dest, exist_ok=True)

        try:
            try:
                if os.path.isdir(src):
                    shutil.copytree(src, dest, dirs_exist_ok=True)
                else:
                    shutil.copy2(src, dest)

            except PermissionError:
                print(colorama.Fore.RED + f"[PermissionError] Failed to copy {src} -> {dest}")

                original_permissions = os.stat(src).st_mode
                new_permissions = original_permissions | 0o600
                os.chmod(src, new_permissions)
                if not retry_flag:
                    return self.copy(src, dest, True)

        except Exception as ex:
            print(colorama.Fore.RED + f"Failed to copy {src} -> {dest}")
            print(colorama.Fore.RED + str(ex))

    def join(self, *paths: list[str]) -> str:
        result_path = paths[0]
        for path in paths[1:]:
            path = self.prefix.join([p for p in path.split(self.prefix) if p.strip()])
            result_path = os.path.join(result_path, path)

        return result_path
