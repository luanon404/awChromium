import os
import json
import shutil
import colorama
from utils import Utils

colorama.init(autoreset=True)


shutil.rmtree("__pycache__", ignore_errors=True)


def update_structure(structure: dict) -> None:
    for key, value in structure.items():
        if isinstance(value, dict):
            if ".java" not in key:
                structure[key] = update_structure(value)
            else:
                dest = utils.join("java", value["dest"])
                target = value["target"][0]
                print(
                    f"[{colorama.Fore.GREEN + 'COPY' + colorama.Style.RESET_ALL}] "
                    f"{colorama.Fore.BLUE + target} "
                    f"{colorama.Fore.MAGENTA + '->'} "
                    f"{colorama.Fore.YELLOW + dest}"
                )
                os.makedirs(dest, exist_ok=True)
                shutil.copy2(target, dest)
    return structure


if __name__ == "__main__":
    prefix = "/"
    utils = Utils(prefix)

    data = json.load(open("structure.json"))
    update_structure(data)
